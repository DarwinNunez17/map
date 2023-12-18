//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Repository;

import Domain.Transfers;
import Observer.TransferObservable;
import Observer.TransferObserver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransfersRepository implements TransferObservable {
    private Connection connection;
    private List<TransferObserver> observers = new ArrayList();

    public TransfersRepository(Connection connection) {
        this.connection = connection;
    }

    public TransfersRepository() {
    }

    public void addTransfer(Transfers transfer) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO transfers (player_id, amount) VALUES (?, ?)");
            statement.setInt(1, transfer.getPlayerID());
            statement.setDouble(2, transfer.getTransferFee());
            statement.executeUpdate();
            this.notifyObservers(transfer);
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public List<Transfers> getAllTransfers() {
        List<Transfers> transfers = new ArrayList();

        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM transfers");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                int playerId = resultSet.getInt("player_id");
                double amount = resultSet.getDouble("amount");
                transfers.add(new Transfers(playerId, amount));
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return transfers;
    }

    public void addObserver(TransferObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(TransferObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(Transfers transfer) {
        Iterator var2 = this.observers.iterator();

        while(var2.hasNext()) {
            TransferObserver observer = (TransferObserver)var2.next();
            observer.update(transfer);
        }

    }
}
