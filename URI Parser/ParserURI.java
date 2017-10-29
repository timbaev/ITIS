import java.util.HashMap;
import java.util.Map;

public class ParserURI {

    private static final String SCHEME = "scheme";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String HOST = "host";
    private static final String PORT = "port";
    private static final String PATH = "path";
    private static final String QUERY = "query";
    private static final String FRAGMENT = "fragment";
    private static final String AUTHORITY = "authority";

    private static Map<String, Object> parse(String uri) {
        Map<String, Object> parameters = new HashMap<>();

        int schemePosition = uri.indexOf(":");
        int authorityPositionStart = uri.indexOf("//");

        String scheme = uri.substring(0, schemePosition);
        parameters.put(SCHEME, scheme);
        String uriWithoutScheme = uri.substring(authorityPositionStart + 2);
        int authorityPositionEnd = -1;
        int pathStartPosition = uriWithoutScheme.indexOf('/');
        int queryStartPosition = uriWithoutScheme.indexOf('?');
        int fragmentStartPosition = uriWithoutScheme.indexOf('#');
        if (pathStartPosition != -1) authorityPositionEnd = pathStartPosition;
        else if (queryStartPosition != -1) authorityPositionEnd = queryStartPosition;
        else if (fragmentStartPosition != -1) authorityPositionEnd = fragmentStartPosition;

        if (authorityPositionEnd != -1) {
            String authority = uriWithoutScheme.substring(0, authorityPositionEnd);
            Map<String, String> authorityParameters = getAuthorityParameters(authority);
            parameters.put(AUTHORITY, authorityParameters);

            String remainder = uriWithoutScheme.substring(authorityPositionEnd);
            Map<String, String> remainderParameters = getReminderParameters(remainder);
            if (remainderParameters.containsKey(PATH)) parameters.put(PATH, remainderParameters.get(PATH));
            if (remainderParameters.containsKey(QUERY)) parameters.put(QUERY, getQueryParameters(remainderParameters.get(QUERY)));
            if (remainderParameters.containsKey(FRAGMENT)) parameters.put(FRAGMENT, remainderParameters.get(FRAGMENT));
        } else {
            parameters.put(AUTHORITY, getAuthorityParameters(uriWithoutScheme));
        }

        return parameters;
    }

    private static Map<String, String> getAuthorityParameters(String authority) {
        Map<String, String> authorityParameters = new HashMap<>();

        int hostStartPosition = authority.indexOf('@');
        boolean userExists = hostStartPosition != -1;

        String hostAuthority = authority;
        if (userExists) {
            String userInfoStr = authority.substring(0, hostStartPosition);
            String[] userInfo = userInfoStr.split(":");
            String username = userInfo[0];
            String password = userInfo[1];
            authorityParameters.put(USERNAME, username);
            authorityParameters.put(PASSWORD, password);

            hostAuthority = authority.substring(hostStartPosition + 1);
        }

        String[] hostInfo = hostAuthority.split(":");
        String host = hostInfo[0];
        authorityParameters.put(HOST, host);
        if (hostInfo.length == 2) {
            String port = hostInfo[1];
            authorityParameters.put(PORT, port);
        }

        return authorityParameters;
    }

    private static Map<String, String> getQueryParameters(String query) {
        Map<String, String> parametersMap = new HashMap<>();

        String[] parameters = query.split("&");
        for (String parameter : parameters) {
            String[] keyValue = parameter.split("=");
            String key = keyValue[0];
            String value = keyValue[1];
            parametersMap.put(key, value);
        }

        return parametersMap;
    }

    private static Map<String, String> getReminderParameters(String remainder) {
        Map<String, String> reminderParameters = new HashMap<>();

        int pathIndexStart = remainder.indexOf('/');
        int queryIndexStart = remainder.indexOf('?');
        int fragmentIndexStart = remainder.indexOf('#');

        boolean pathExists = pathIndexStart != -1;
        boolean queryExists = queryIndexStart != -1;
        boolean fragmentExists = fragmentIndexStart != -1;

        if (pathExists) {
            String path;
            if (queryExists) path = remainder.substring(pathIndexStart + 1, queryIndexStart);
            else if (fragmentExists) path = remainder.substring(pathIndexStart + 1, fragmentIndexStart);
            else path = remainder.substring(pathIndexStart + 1);
            reminderParameters.put(PATH, path);
        }
        if (queryExists) {
            String query;
            if (fragmentExists) query = remainder.substring(queryIndexStart + 1, fragmentIndexStart);
            else query = remainder.substring(queryIndexStart + 1);
            reminderParameters.put(QUERY, query);
        }
        if (fragmentExists) {
            String fragment;
            fragment = remainder.substring(fragmentIndexStart + 1);
            reminderParameters.put(FRAGMENT, fragment);
        }

        return reminderParameters;
    }

    public static void main(String[] args) {
        String uriSimple = "foo://username:password@www.example.com:8080";
        String uriWithFragment = "foo://username:password@www.example.com:8080#fragment";
        String uriWithQuery = "foo://username:password@www.example.com:8080?arg=val&arg2=val2";
        String uriWithoutPath = "foo://username:password@www.example.com:8080?arg=val&arg2=val2#fragment";
        String uriWithPath = "foo://username:password@www.example.com:8080/hello/index.html";
        String uriWithoutQuery = "foo://username:password@www.example.com:8080/hello/index.html#fragment";
        String uriWithoutFragment = "foo://username:password@www.example.com:8080/hello/index.html?arg=val&arg2=val2";
        String uriFull = "foo://username:password@www.example.com:8080/hello/index.html?arg=val&arg2=val2#fragment";

        System.out.println(ParserURI.parse(uriSimple));
        System.out.println(ParserURI.parse(uriWithFragment));
        System.out.println(ParserURI.parse(uriWithQuery));
        System.out.println(ParserURI.parse(uriWithoutPath));
        System.out.println(ParserURI.parse(uriWithPath));
        System.out.println(ParserURI.parse(uriWithoutQuery));
        System.out.println(ParserURI.parse(uriWithoutFragment));
        System.out.println(ParserURI.parse(uriFull));
        System.out.println("-------------------------------------");

        String uriSimpleAuth = "foo://www.example.com";
        String uriWithPort = "foo://www.example.com:8080";
        String uriWithUserInfo = "foo://username:password@www.example.com";
        String uriFullAuth = "foo://username:password@www.example.com:8080";

        System.out.println(ParserURI.parse(uriSimpleAuth));
        System.out.println(ParserURI.parse(uriWithPort));
        System.out.println(ParserURI.parse(uriWithUserInfo));
        System.out.println(ParserURI.parse(uriFullAuth));
    }

}
