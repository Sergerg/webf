package serger.webf.beads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultDemoService implements DemoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public DefaultDemoService() {
        log.info("create");
    }

    @Override
    public String getHello(String man) {
        return "Hello, "+man+"!";
    }
}
