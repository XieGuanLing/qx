package com.ws.http;

import org.apache.log4j.Logger;
import org.springframework.session.Session;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

/**
 */
public class HttpSessionStrategyImpl implements HttpSessionStrategy {

    private static final Logger logger = Logger.getLogger(HttpSessionStrategyImpl.class);

    private static final String SESSION_IDS_WRITTEN_ATTR = "_SESSION_IDS_WRITTEN_ATTR_";

    public  static final String SID = "sid";

    @Override
    public String getRequestedSessionId(HttpServletRequest request) {
        if (request == null)
            return null;

        String sid = request.getHeader(SID);
        if (sid == null)
            sid = request.getParameter(SID);

        if (sid == null) {
            Cookie cookie = getCookieFromRequest(request, SID);
            if (cookie != null)
                sid = cookie.getValue();
        }
        return sid;
    }

    private static Cookie getCookieFromRequest(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    @Override
    public void onNewSession(Session session, HttpServletRequest request, HttpServletResponse response) {

        Set<String> sessionIdsWritten = getSessionIdsWritten(request);
        if (sessionIdsWritten.contains(session.getId())) {
            return;
        }

        if (logger.isDebugEnabled())
            logger.debug("new session created.session id:" + session.getId());

        sessionIdsWritten.add(session.getId());

        responseSid(session.getId(), request, response);
    }

    private Set<String> getSessionIdsWritten(HttpServletRequest request) {
        Set<String> sessionsWritten = (Set<String>) request.getAttribute(SESSION_IDS_WRITTEN_ATTR);
        if (sessionsWritten == null) {
            sessionsWritten = new HashSet<>();
            request.setAttribute(SESSION_IDS_WRITTEN_ATTR, sessionsWritten);
        }
        return sessionsWritten;
    }

    @Override
    public void onInvalidateSession(HttpServletRequest request, HttpServletResponse response) {

    }

    public void responseSid(String sid, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader(SID, sid);

        Cookie sidCookie = getCookieFromRequest(request, SID);
        if (sidCookie == null) {
            sidCookie = new Cookie(SID, sid);
            sidCookie.setPath(request.getContextPath() + "/");
        } else if (!sid.equals(sidCookie.getValue())) {
            // notify browser invalidate this cookie
            sidCookie.setMaxAge(0);
            response.addCookie(sidCookie);

            // create new valid cookie
            sidCookie = new Cookie(SID, sid);
            sidCookie.setPath(request.getContextPath() + "/");
        }

        response.addCookie(sidCookie);
    }

}
