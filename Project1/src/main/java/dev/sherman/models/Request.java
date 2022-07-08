package dev.sherman.models;

public class Request {

	private int requestId;
	private String requestDate;
	private String requestStatus;
	private String compProof;
	private String eventDate;
	private String eventTime;
	private String eventLocation;
	private String eventDesc;
	private double eventCost;
	private String eventType;
	private String workJust;
	private double projReim;
	private String gradeReq;
	private String gradeFormat;
	private int empId;
	
	public Request() {
		super();
	}
	
	public Request(int requestId, String requestDate, String requestStatus, String compProof,
			String eventDate, String eventTime, String eventLocation, String eventDesc, double eventCost,
			String eventType, String workJust, double projReim, String gradeReq, String gradeFormat,
			int empId) {
				super();
				this.requestId = requestId;
				this.requestDate = requestDate;
				this.requestStatus = requestStatus;
				this.compProof = compProof;
				this.eventDate = eventDate;
				this.eventTime = eventTime;
				this.eventLocation = eventLocation;
				this.eventDesc = eventDesc;
				this.eventCost = eventCost;
				this.eventType = eventType;
				this.workJust = workJust;
				this.projReim = projReim;
				this.gradeReq = gradeReq;
				this.gradeFormat = gradeFormat;
				this.empId = empId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getCompProof() {
		return compProof;
	}

	public void setCompProof(String compProof) {
		this.compProof = compProof;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public double getEventCost() {
		return eventCost;
	}

	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getWorkJust() {
		return workJust;
	}

	public void setWorkJust(String workJust) {
		this.workJust = workJust;
	}

	public double getProjReim() {
		return projReim;
	}

	public void setProjReim(double projReim) {
		this.projReim = projReim;
	}

	public String getGradeReq() {
		return gradeReq;
	}

	public void setGradeReq(String gradeReq) {
		this.gradeReq = gradeReq;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestDate=" + requestDate + ", requestStatus=" + requestStatus
				+ ", compProof=" + compProof + ", eventDate=" + eventDate + ", eventTime=" + eventTime
				+ ", eventLocation=" + eventLocation + ", eventDesc=" + eventDesc + ", eventCost=" + eventCost
				+ ", eventType=" + eventType + ", workJust=" + workJust + ", projReim=" + projReim + ", gradeReq="
				+ gradeReq + ", gradeFormat=" + gradeFormat + ", empId=" + empId + "]";
	}
	
}
