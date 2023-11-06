package Controller;

import Domain.Transfers;

public interface TransfersObserver {
    void updateTransferAdded(Transfers transfer);
}
