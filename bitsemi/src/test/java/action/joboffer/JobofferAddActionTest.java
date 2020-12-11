package action.joboffer;

import data.dao.JobofferDao;
import data.dto.JobofferDto;
import org.junit.jupiter.api.Test;

class JobofferAddActionTest {

    @Test
    void execute() {
        JobofferDto dto = new JobofferDto(
                "",
                "yang",
                "company",
                "010-1234-1234",
                "seoul",
                "cafe",
                "day",
                "this is alba",
                "10000",
                "2020-12-01",
                "5",
                "[yang0,yang1,yang2,yang3,yang4,yang5,yang6,yang7]",//List<String> 을 String 으로 변환한 것.
                "37.56805903574687",
                "126.98142512109087",
                "장기"
        );
        JobofferDao dao = new JobofferDao();
        System.out.println("insert success " + dto.getId());
        System.out.println("insert success " + dto.getLocation());
        System.out.println("insert success " + dto.getJobtype());
        System.out.println("insert success " + dto.getAbletime());
        System.out.println("insert success " + dto.getIntroduce());
        System.out.println("insert success " + dto.getPay());
        System.out.println("insert success " + dto.getWriteday());
        System.out.println("insert success " + dto.getNeedpeople());
        System.out.println("insert success " + dto.getApplicant());


    }
}