package unit.im.turms.server.common.cluster.service.idgen;

import im.turms.server.common.cluster.service.idgen.FlakeIdGenerator;
import im.turms.server.common.util.MapUtil;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlakeIdGeneratorTests {

    @Test
    void getFlakeId_shouldGenerateUniqueAndIncrementingId() {
        FlakeIdGenerator generator = new FlakeIdGenerator(0, 0);
        int number = 10_000;
        Set<Long> ids = new HashSet<>(MapUtil.getCapability(number));
        long previousId = -1;
        for (int i = 0; i < number; i++) {
            long newId = generator.getFlakeId();
            assertThat("ID should increment", newId, greaterThan(previousId));
            boolean added = ids.add(newId);
            assertTrue(added, "ID is duplicate");
            previousId = newId;
        }
    }

}