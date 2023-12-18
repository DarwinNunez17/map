package Observer;

import Domain.Transfers;
public interface TransferObservable {
    void addObserver(TransferObserver observer);
    void removeObserver(TransferObserver observer);
    void notifyObservers(Transfers transfer);
}
