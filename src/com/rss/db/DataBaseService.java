package com.rss.db;

import com.rss.common.Constants;
import com.rss.exceptions.DBException;
import com.rss.pojo.modals.*;
import com.rss.util.ResultSetMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class DataBaseService {
    DBManager dbManager = DBManager.getInstance();
    ResultSetMapper resultSetMapper = new ResultSetMapper();

    public GameConfig getGameConfig(int gameConfigId) throws DBException {
        PreparedStatement stmt = null;
        GameConfig gameConfig = new GameConfig();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT * FROM GAME_CONFIGS WHERE ID = " + gameConfigId + ";";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                gameConfig = (GameConfig) resultSetMapper.mapRersultSetToObject(rs, GameConfig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return gameConfig;
    }

    public LastGame getLastGame(String gameId, int accountId) throws DBException {
        PreparedStatement stmt = null;
        LastGame lastGame = new LastGame();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT * FROM LASTGAME WHERE game_id = " + gameId + " AND account_id =" + accountId + " +;";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lastGame = (LastGame) resultSetMapper.mapRersultSetToObject(rs, LastGame.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return lastGame;
    }

    public LastGame removeOldGame(int accountId, String gameId) throws DBException {
        PreparedStatement stmt = null;
        LastGame lastGame = new LastGame();
        try {
            Connection con = dbManager.getConnection();
            String query = "DELETE  FROM LASTGAME WHERE game_id = " + gameId + " AND account_id =" + accountId + " +;";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lastGame = (LastGame) resultSetMapper.mapRersultSetToObject(rs, LastGame.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return lastGame;
    }

    public GameLog createGameLogsRecords(GameLog gameLog) throws DBException {
        PreparedStatement stmt = null;
        GameLog gameLogs = new GameLog();
        try {
            Connection con = dbManager.getConnection();
            String query = "INSERT  INTO gamelog";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                gameLogs = (GameLog) resultSetMapper.mapRersultSetToObject(rs, GameLog.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return gameLogs;
    }

    public SpinDetails logSpinDetails(GameLog gameLog) throws DBException {
        PreparedStatement stmt = null;
        SpinDetails spinDetails = new SpinDetails();
        try {
            Connection con = dbManager.getConnection();
            String query = "INSERT  INTO gamelog";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                spinDetails = (SpinDetails) resultSetMapper.mapRersultSetToObject(rs, SpinDetails.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return spinDetails;
    }

    public TransactionsLog logTransaction(GameLog gameLog) throws DBException {
        PreparedStatement stmt = null;
        TransactionsLog transactionsLog = new TransactionsLog();
        try {
            Connection con = dbManager.getConnection();
            String query = "INSERT  INTO gamelog";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                transactionsLog = (TransactionsLog) resultSetMapper.mapRersultSetToObject(rs, TransactionsLog.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return transactionsLog;
    }

    public Gamble createGambleRecord(Gamble gamble) throws DBException {
        PreparedStatement stmt = null;
        Gamble gambleData = new Gamble();
        try {
            Connection con = dbManager.getConnection();
            String query = "INSERT  INTO gamelog";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                gambleData = (Gamble) resultSetMapper.mapRersultSetToObject(rs, Gamble.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return gambleData;
    }

    public Gamble getGambleRecordByUser(int accountId, String gameId) throws DBException {
        PreparedStatement stmt = null;
        Gamble gamble = new Gamble();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT * FROM gamble WHERE account_id =" + accountId + "AND game_id =" + gameId + ";";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                gamble = (Gamble) resultSetMapper.mapRersultSetToObject(rs, Gamble.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return gamble;
    }

    public Gamble getGambleRecord(int accountId, String gameId) throws DBException {
        PreparedStatement stmt = null;
        Gamble gamble = new Gamble();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT * FROM gamble WHERE account_id =" + accountId + "AND game_id =" + gameId + ";";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                gamble = (Gamble) resultSetMapper.mapRersultSetToObject(rs, Gamble.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return gamble;
    }

    public Gamble getGambleRecordByUser(int gameSpinId) throws DBException {
        PreparedStatement stmt = null;
        Gamble gamble = new Gamble();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT * FROM gamble WHERE gamespin_id =" + gameSpinId + ";";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                gamble = (Gamble) resultSetMapper.mapRersultSetToObject(rs, Gamble.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return gamble;
    }

    public LastGame setLastGame(LastGame lastGame) throws DBException {
        PreparedStatement stmt = null;
        LastGame game = new LastGame();
        try {
            Connection con = dbManager.getConnection();
            String query = "INSERT INTO ()";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                game = (LastGame) resultSetMapper.mapRersultSetToObject(rs, LastGame.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return game;
    }

    public LastGame updateLastGame(LastGame lastGame) throws DBException {
        PreparedStatement stmt = null;
        LastGame game = new LastGame();
        try {
            Connection con = dbManager.getConnection();
            String query = "UPDATE lastgame SET  WHERE ACCOUNT_ID =" + lastGame.getAccountId() + "AND game_id =" + lastGame.getGameId() + ";";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                game = (LastGame) resultSetMapper.mapRersultSetToObject(rs, LastGame.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return game;
    }

    public FreeSpins getLastGameAwardedFreeSpins(int gameId, String accountId, int spinId) throws DBException {
        PreparedStatement stmt = null;
        FreeSpins freeSpins = new FreeSpins();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT * FROM freespins WHERE account_id =" + accountId + " AND game_id =" + gameId + "AND spin_id =" + spinId + " AND state =" + Constants.FREESPIN_STATES.get(Constants.AWARDED) + ";";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                freeSpins = (FreeSpins) resultSetMapper.mapRersultSetToObject(rs, FreeSpins.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return freeSpins;
    }

    public FreeSpins getLastGameFreespins(int gameId, String accountId, int spinId) throws DBException {
        PreparedStatement stmt = null;
        FreeSpins freeSpins = new FreeSpins();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT * FROM freespins WHERE account_id =" + accountId + " AND game_id =" + gameId + "AND spin_id =" + spinId + " AND state =" + Constants.FREESPIN_STATES.get(Constants.AWARDED) + "," + Constants.FREESPIN_STATES.get(Constants.SELECTED) + "," + Constants.FREESPIN_STATES.get(Constants.INPROGRESS) + ";";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                freeSpins = (FreeSpins) resultSetMapper.mapRersultSetToObject(rs, GameConfig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return freeSpins;
    }

    public GameConfig createGameConfig(GameConfig gameConfig) throws DBException {
        PreparedStatement stmt = null;
        GameConfig config = new GameConfig();
        try {
            Connection con = dbManager.getConnection();
            String query = "INSERT INTO game_configs ()";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                config = (GameConfig) resultSetMapper.mapRersultSetToObject(rs, GameConfig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return config;
    }

    public SuggestedPayLines createSuggestedPayLines(SuggestedPayLines suggestedPayLines) throws DBException {
        PreparedStatement stmt = null;
        SuggestedPayLines payLines = new SuggestedPayLines();
        try {
            Connection con = dbManager.getConnection();
            String query = "INSERT INTO suggested_paylines () ";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payLines = (SuggestedPayLines) resultSetMapper.mapRersultSetToObject(rs, SuggestedPayLines.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return payLines;
    }

    public SuggestedPayLines updateSuggestedPayLines(SuggestedPayLines suggestedPayLines) throws DBException {
        PreparedStatement stmt = null;
        SuggestedPayLines payLines = new SuggestedPayLines();
        try {
            Connection con = dbManager.getConnection();
            String query = "UPDATE suggested_paylines SET WHERE id = " + suggestedPayLines.getId() + "; ";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payLines = (SuggestedPayLines) resultSetMapper.mapRersultSetToObject(rs, GameConfig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return payLines;
    }

    public List<SuggestedPayLines> getSuggestedPayLines(int cols, int rows) throws DBException {
        PreparedStatement stmt = null;
        List<SuggestedPayLines> payLines = new ArrayList<>();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT  * FROM suggested_paylines  WHERE columns = " + cols + "AND rows= " + rows + ";";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payLines = (List<SuggestedPayLines>) resultSetMapper.mapRersultSetToList(rs, SuggestedPayLines.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException((e.getLocalizedMessage()));
        }
        return payLines;
    }

    public AlwaysSlots createAlwaysSlotsPayLines(AlwaysSlots alwaysSlots) throws DBException {
        PreparedStatement preparedStatement = null;
        AlwaysSlots slots = new AlwaysSlots();
        try {
            Connection con = dbManager.getConnection();
            String query = "INSERT INTO always_slots ()";
            preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                slots = (AlwaysSlots) resultSetMapper.mapRersultSetToObject(rs, AlwaysSlots.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return slots;
    }

    public AlwaysSlots updateAlwaysSlotsPayLines(AlwaysSlots alwaysSlots) throws DBException {
        PreparedStatement preparedStatement = null;
        AlwaysSlots slots = new AlwaysSlots();
        try {
            Connection con = dbManager.getConnection();
            String query = "UPDATE always_slots SET WHERE id = " + alwaysSlots.getId() + ";";
            preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                slots = (AlwaysSlots) resultSetMapper.mapRersultSetToObject(rs, AlwaysSlots.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return slots;
    }

    public List<AlwaysSlots> getAlwaysSlotsPayLines(int columns, int rows) throws DBException {
        PreparedStatement preparedStatement = null;
        List<AlwaysSlots> slots = new ArrayList<>();
        try {
            Connection con = dbManager.getConnection();
            String query = "SELECT  * FROM always_slots WHERE columns = " + columns + "AND rows = " + rows + ";";
            preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                slots = (List<AlwaysSlots>) resultSetMapper.mapRersultSetToList(rs, AlwaysSlots.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return slots;
    }

    public LastGame deleteFromLastGame(int accountId, int gameId) throws DBException {
        PreparedStatement preparedStatement = null;
        LastGame lastGame = new LastGame();
        try {
            Connection con = dbManager.getConnection();
            String query = "DELETE FROM lastgame WHERE account_id =" + accountId + "AND game_id = " + gameId + ";";
            preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                lastGame = (LastGame) resultSetMapper.mapRersultSetToObject(rs, LastGame.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return lastGame;
    }

    public FreeSpins deleteFromFreeSpins(int accountId, int gameId) throws DBException {
        PreparedStatement preparedStatement = null;
        FreeSpins freeSpins = new FreeSpins();
        try {
            Connection connection = dbManager.getConnection();
            String query = "DELETE FROM freespins WHERE account_id =" + accountId + "AND game_id = " + gameId + ";";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                freeSpins = (FreeSpins) resultSetMapper.mapRersultSetToObject(resultSet, FreeSpins.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return freeSpins;
    }

    public Gamble deleteFromGambles(int accountId, int gameId) throws DBException {
        PreparedStatement preparedStatement = null;
        Gamble gamble = new Gamble();
        try {
            Connection connection = dbManager.getConnection();
            String query = "DELETE FROM gamble WHERE account_id =" + accountId + "AND game_id = " + gameId + ";";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                gamble = (Gamble) resultSetMapper.mapRersultSetToObject(resultSet, Gamble.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return gamble;
    }

    public List<ProducerPaylines> getProducerPayLinesForName(int producerId, int cols, int rows, String name) throws DBException {
        PreparedStatement preparedStatement = null;
        List<ProducerPaylines> producerPaylines = new ArrayList<>();
        try {
            Connection connection = dbManager.getConnection();
            String query = "SELECT * FROM producer_paylines WHERE producer_id =" + producerId + "AND columns = " + cols + "AND rows =" + rows + "AND NAME =" + name + ";";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                producerPaylines = (List<ProducerPaylines>) resultSetMapper.mapRersultSetToList(resultSet, ProducerPaylines.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return producerPaylines;
    }

    public FreeSpinsLogs createFreespinsLogs(FreeSpinsLogs freeSpinsLogs) throws DBException {
        PreparedStatement preparedStatement = null;
        FreeSpinsLogs spinsLogs = new FreeSpinsLogs();
        try {
            Connection connection = dbManager.getConnection();
            String query = "INSERT INTO freespinslogs ()";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                spinsLogs = (FreeSpinsLogs) resultSetMapper.mapRersultSetToObject(resultSet, FreeSpinsLogs.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return spinsLogs;
    }

    public FreeSpins createFreespins(FreeSpins freeSpins) throws DBException {
        PreparedStatement preparedStatement = null;
        FreeSpins spins = new FreeSpins();
        try {
            Connection connection = dbManager.getConnection();
            String query = "INSERT INTO freespins ()";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                spins = (FreeSpins) resultSetMapper.mapRersultSetToObject(resultSet, FreeSpins.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return spins;
    }

    public List<FreeSpins> readFreespins(String gameId, int accountId, int spinId, int state) throws DBException {
        PreparedStatement preparedStatement = null;
        List<FreeSpins> spins = new ArrayList<>();
        try {
            Connection connection = dbManager.getConnection();
            String query = "SELECT * FROM freespins WHERE account_id =" + accountId + "AND game_id = " + gameId + "AND spin_id =" + spinId + "AND state = " + state + ";";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                spins = (List<FreeSpins>) resultSetMapper.mapRersultSetToList(resultSet, FreeSpins.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return spins;
    }

    public List<FreeSpins> readAllFreespins(String gameId, int accountId, int state) throws DBException {
        PreparedStatement preparedStatement = null;
        List<FreeSpins> spins = new ArrayList<>();
        try {
            Connection connection = dbManager.getConnection();
            String query = "SELECT * FROM freespins WHERE account_id =" + accountId + "AND game_id = " + gameId + "AND state = " + state + ";";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                spins = (List<FreeSpins>) resultSetMapper.mapRersultSetToList(resultSet, FreeSpins.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return spins;
    }

    public FreeSpins updateFreespin(int id, FreeSpins freeSpins) throws DBException {
        PreparedStatement preparedStatement = null;
        FreeSpins spins = new FreeSpins();
        try {
            Connection connection = dbManager.getConnection();
            String query = "UPDATE freespins SET WHERE id =" + id + ";";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                spins = (FreeSpins) resultSetMapper.mapRersultSetToObject(resultSet, FreeSpins.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return spins;
    }

    public FreeSpins disableFreespin(int id) throws DBException {
        PreparedStatement preparedStatement = null;
        FreeSpins spins = new FreeSpins();
        try {
            Connection connection = dbManager.getConnection();
            String query = "UPDATE freespins SET STATE = " + Constants.FREESPIN_STATES.get(Constants.COMPLETED) + " WHERE id =" + id + ";";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                spins = (FreeSpins) resultSetMapper.mapRersultSetToObject(resultSet, FreeSpins.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return spins;
    }

    public FreeSpins removeFreespin(int id) throws DBException {
        PreparedStatement preparedStatement = null;
        FreeSpins spins = new FreeSpins();
        try {
            Connection connection = dbManager.getConnection();
            String query = "DELETE FROM freespins  WHERE id =" + id + ";";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                spins = (FreeSpins) resultSetMapper.mapRersultSetToObject(resultSet, FreeSpins.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return spins;
    }

    public Notifications createNotification( Notifications notifications ) throws DBException {
        PreparedStatement preparedStatement = null;
        Notifications notification = new Notifications();
        try {
            Connection connection = dbManager.getConnection();
            String query = "INSERT INTO notifications()";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                notification = (Notifications) resultSetMapper.mapRersultSetToObject(resultSet, Notifications.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return notification;
    }

    public Notifications updateNotificationObj( Notifications notifications ) throws DBException {
        PreparedStatement preparedStatement = null;
        Notifications notification = new Notifications();
        try {
            Connection connection = dbManager.getConnection();
            String query = "UPDATE notifications SET ";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                notification = (Notifications) resultSetMapper.mapRersultSetToObject(resultSet, Notifications.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e.getLocalizedMessage());
        }
        return notification;
    }
}
