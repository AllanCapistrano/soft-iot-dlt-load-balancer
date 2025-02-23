package dlt.load.balancer.model;

import dlt.client.tangle.model.transactions.Transaction;
import dlt.client.tangle.services.ILedgerReader;
import dlt.client.tangle.services.ILedgerSubscriber;
import dlt.client.tangle.services.ILedgerWriter;

/**
 *
 * @author  Antonio Crispim, Uellington Damasceno
 * @version 0.0.1
 */
public class LedgerConnector {

    private ILedgerReader ledgerReader;
    private ILedgerWriter ledgerWriter;

    public void setLedgerWriter(ILedgerWriter ledgerWriter) {
        this.ledgerWriter = ledgerWriter;
    }

    public void setLedgerReader(ILedgerReader ledgerReader) {
        this.ledgerReader = ledgerReader;
    }

    public void subscribe(String topic, ILedgerSubscriber iLedgerSubscriber) {
        this.ledgerReader.subscribe(topic, iLedgerSubscriber);
    }

    public void unsubscribe(String topic, ILedgerSubscriber iLedgerSubscriber) {
        this.ledgerReader.unsubscribe(topic, iLedgerSubscriber);
    }

    public void put(Transaction transaction) throws InterruptedException {
        this.ledgerWriter.put(transaction);
    }

    public Transaction getTransactionByHash(String hash) {
        return this.ledgerWriter.getTransactionByHash(hash);
    }

    public ILedgerWriter getLedgerWriter() {
      return ledgerWriter;
    }
}
