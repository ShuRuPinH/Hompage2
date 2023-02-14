package in.shurup.service;


import in.shurup.data.DataWays;
import in.shurup.model.Page;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class DataService {
    private static Logger log = Logger.getLogger("FileService");

    public Map<Integer, Page> data() {
        return DataWays.getWays();
    }

}
