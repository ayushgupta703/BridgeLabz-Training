package bridgeLabz_Training.jdbc.dao;

import java.util.List;

public interface AuditLogDAO {

    List<String> getAuditLogs(String table, String user);
}