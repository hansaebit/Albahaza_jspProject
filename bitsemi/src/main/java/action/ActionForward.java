package action;

public class ActionForward {
    private String path;
    private boolean isRedirect;
    private boolean isChangePage;
    private String printData;

    public ActionForward() {
        System.out.println("init ActionForward.");
        this.printData = "";
        this.path = "/";
        this.isRedirect = false;
        this.isChangePage = false;
    }

    public boolean isChangePage() {
        return isChangePage;
    }

    public void setChangePage(boolean changePage) {
        isChangePage = changePage;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    public String getPrintData() {
        return printData;
    }

    public void setPrintData(String printData) {
        this.printData = printData;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
