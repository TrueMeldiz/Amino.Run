package sapphire.policy.transaction;

import org.junit.Test;
import sapphire.common.AppObject;

import java.io.Serializable;
import java.util.UUID;

import static org.junit.Assert.assertNotSame;

public class AppObjectSandboxProviderTest {
    @Test
    public void test_get_copy_of_appObject() throws Exception {
        UUID txId = UUID.randomUUID();
        Serializable coreOrigin = "aaa";
        AppObject originAppObject = new AppObject(coreOrigin);
        TwoPCCohortPolicy.TwoPCCohortServerPolicy origin = new TwoPCCohortPolicy.TwoPCCohortServerPolicy();
        origin.$__initialize(originAppObject);

        AppObjectSandboxProvider provider = new AppObjectSandboxProvider();
        AppObjectShimServerPolicy sandbox = (AppObjectShimServerPolicy)provider.getSandbox(origin, txId);

        AppObject sandboxAppObject = sandbox.getAppObject();
        assertNotSame(sandboxAppObject, originAppObject);
    }
}
