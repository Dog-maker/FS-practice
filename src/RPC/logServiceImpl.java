package RPC;

public class logServiceImpl implements logService{
    @Override
    public String getLog(String log) {
        return "I am getLog,my message is "+log;
    }

    @Override
    public String toLog(String log) {
        return "I am toLog,i wank to toLog,and log is "+log;

    }
}
