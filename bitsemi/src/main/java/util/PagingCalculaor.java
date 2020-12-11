package util;

public class PagingCalculaor {
    private int totalCount;
    private int perPage;
    private int perBlock;
    private int totalPage;
    private int startPage;
    private int endPage;
    private int start;
    private int end;
    private int currentPage;
    private int no;          //각 페이지에 시작하는 시작번호

    public PagingCalculaor(int totalCount, int perPage, int perBlock, int currentPage) {
        this.perPage = perPage;
        this.perBlock = perBlock;
        this.currentPage = currentPage;
        this.totalCount = totalCount;

        totalPage = totalCount / perPage + (totalCount % perPage > 0 ? 1 : 0);
        //시작페이지, 끝페이지 구하기
        startPage = (currentPage - 1) / perBlock * perBlock + 1;
        endPage = startPage + perBlock - 1;

        if (endPage > totalPage)
            endPage = totalPage;
        start = (currentPage - 1) * perPage;

        int no = totalCount - (currentPage - 1) * perPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPerBlock() {
        return perBlock;
    }

    public void setPerBlock(int perBlock) {
        this.perBlock = perBlock;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
