package tools;

import java.util.Enumeration;

public class Functions {
    public static String debug(Object o) {
        StringBuilder res = new StringBuilder();
        res.append("<pre style='border : solid 2px blue;'>");
        if (o instanceof javax.servlet.http.HttpSession) {
            javax.servlet.http.HttpSession globalVar = (javax.servlet.http.HttpSession) o;
            Enumeration<String> names = globalVar.getAttributeNames();
            res.append("Session : <br>");

            while (names.hasMoreElements()) {
                String name = names.nextElement();
                res.append("<span style='color:red;'>" + name + "</span> = " + globalVar.getAttribute(name) + "<br>" + "<br>");
            }


        } else if (o instanceof javax.servlet.http.HttpServletRequest) {
            javax.servlet.http.HttpServletRequest globalVar = (javax.servlet.http.HttpServletRequest) o;
            Enumeration<String> names = globalVar.getParameterNames();

            res.append("request : <br>");

            while (names.hasMoreElements()) {
                String name = names.nextElement();
                res.append("<span style='color:red;'>" + name + "</span> = " + globalVar.getParameter(name) + "<br>" + "<br>");
            }
        }
        res.append("</pre>");
        return res.toString();
    }
}
