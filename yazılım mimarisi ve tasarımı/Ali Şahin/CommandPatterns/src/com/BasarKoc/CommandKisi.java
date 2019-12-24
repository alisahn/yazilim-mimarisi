package com.BasarKoc;

public abstract class CommandKisi {
    protected ReceiverKisi _receiverKisi;
    public CommandKisi(ReceiverKisi receiverKisi)
    {
        this._receiverKisi = receiverKisi;
    }

    public abstract void Execute();
}
