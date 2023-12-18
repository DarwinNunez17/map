package Observer;

import Domain.Transfers;

public interface TransferObserver {
    void update(Transfers transfer);
}
