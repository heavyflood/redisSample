package com.example.demo;

import java.io.Serializable;

public class SessionVO implements Serializable {
	   private static final long serialVersionUID = 1L;
	    private String sessionId;
	    private String sessionSeq;
	    
	    public String getSessionId() {
			return sessionId;
		}
		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}
		public String getSessionSeq() {
			return sessionSeq;
		}
		public void setSessionSeq(String sessionSeq) {
			this.sessionSeq = sessionSeq;
		}
		public SessionVO(String sessionId, String sessionSeq) {
	        super();
	        this.sessionId = sessionId;
	        this.sessionSeq = sessionSeq;
	    }
	    public SessionVO() {}
	    
	    @Override
	    public String toString() {
	        return "DataType [sessionId=" + sessionId + ", sessionSeq=" + sessionSeq + "]";
	    }
}
