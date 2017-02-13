package CW_9Febrary.recognizer;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Timbaev on 13.02.2017.
 * SpeechKit Utils from Yandex
 */
public class SpeechKit {

    private final static String KEY = "80699c66-4559-4128-833b-4ee4d435ecd9";
    private static final String UUID = "01ae13cb744628b58fb536d496daa1e6";
    private static final String TOPIC = "notes";
    private static final String SpeechRecognitionURI = "https://asr.yandex.net/asr_xml?";
    private static String expression = "//recognitionResults/variant";

    private static String speaker = "zahar";
    private static String format = "wav";
    private static String emotion = "evil";
    private static String robot = "false";
    private static String textRecognitionURI = "https://tts.voicetech.yandex.net/generate?";

    public static ArrayList<String> sendPOST(byte[] bytes) throws RecognitionSpeechException {

        try{

            String params = "key="+KEY+"&uuid="+UUID+"&topic="+TOPIC;

            String uri = SpeechRecognitionURI+params;

            URL url = new URL(uri);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();


            conn.setRequestMethod("POST");

            conn.addRequestProperty("Content-Type","audio/x-pcm;bit=16;rate=16000");   //see yandex.ru the advice this
            conn.addRequestProperty("Host","asr.yandex.net");
            conn.setDoOutput(true);

            //writing audio data
            try(DataOutputStream out = new DataOutputStream(conn.getOutputStream())){
                out.write(bytes,0,bytes.length);
            } catch (IOException e) {
                throw new RecognitionSpeechException(e.getMessage());
            }

            int responseCode = conn.getResponseCode();

            if (responseCode != 200){
                throw new RecognitionSpeechException("Can't send and recognize speech");
            }

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
                String s;
                StringBuilder sb = new StringBuilder();
                while ((s = reader.readLine()) != null){
                    sb.append(s);
                }

                return getInternalXMLText(sb);
            }

        }catch (Exception e){
            throw new RecognitionSpeechException(e.getMessage());
        }
    }

    private static ArrayList<String> getInternalXMLText(StringBuilder xml) throws RecognitionSpeechException {

        ArrayList<String> arrayList = new ArrayList<>();

        try {
            ByteArrayInputStream in = new ByteArrayInputStream(xml.toString().getBytes("UTF-8"));

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(in);

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression expression = xPath.compile(SpeechKit.expression);

            NodeList nodeList = (NodeList) expression.evaluate(document, XPathConstants.NODESET);


            for (int i = 0; i < nodeList.getLength(); i++) {
                arrayList.add(nodeList.item(i).getTextContent());
            }

        } catch (ParserConfigurationException | XPathExpressionException | SAXException | IOException e) {
            throw new RecognitionSpeechException(e.getMessage());
        }


        return arrayList;
    }

    public static byte[] sendGET(String textToSend) throws TextRecognitionException {

        try{

            String text = URLEncoder.encode(textToSend,"UTF8");

            String params = "text=\""+text+"\"&format="+format+"&speaker="+speaker+"&key="+KEY+"&emotion="+emotion+"&robot="+robot;

            URL url = new URL(textRecognitionURI+params);

            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setDoOutput(true);

            byte [] buff = new byte[1024]; //buffer for reading bytes

            try(ByteArrayOutputStream res = new ByteArrayOutputStream();
                BufferedInputStream in = new BufferedInputStream(conn.getInputStream())
            ){
                int i;
                while ( (i = in.read(buff,0,buff.length)) > 0){
                    res.write(buff,0,i);
                }
                return res.toByteArray();
            }

        }catch (Exception e){
            throw new TextRecognitionException(e.getMessage());
        }
    }
}
