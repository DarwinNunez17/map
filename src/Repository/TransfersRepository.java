package Repository;

import Domain.Transfers;

import java.util.ArrayList;
import java.util.List;

public class TransfersRepository {
    private List<Transfers> transfers = new ArrayList<>();

    public void addTransfer(Transfers transfer) {
        transfers.add(transfer);
    }

    public List<Transfers> getAllTransfers() {
        return transfers;
    }

}
