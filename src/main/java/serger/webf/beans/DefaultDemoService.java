package serger.webf.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import serger.webf.beans.repo.UsersRepo;

public class DefaultDemoService implements DemoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UsersRepo usersRepo;

    public DefaultDemoService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
        log.info("create");
    }

    @Override
    public String getHello(String man) {
        return "Hello, "+ usersRepo.findFirstByName(man)+"!";
    }
}
