import React, { useState, useEffect } from 'react';
import './App.css';

//Erster Entwurf des Frontends zur Interaktion mit dem Backend

function App() {
  const [accounts, setAccounts] = useState([]);
  const [accountId, setAccountId] = useState('');
  const [amount, setAmount] = useState('');
  const [receiverId, setReceiverId] = useState('');

  useEffect(() => {
    fetchAccounts();
  }, []);

  const fetchAccounts = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/accounts');
      const data = await response.json();
      setAccounts(data);
    } catch (error) {
      console.error('Error fetching accounts:', error);
    }
  };

  const createAccount = async () => {
    try {
      await fetch('http://localhost:8080/api/accounts', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: parseInt(accountId), kontostand: 0 }),
      });
      fetchAccounts();
    } catch (error) {
      console.error('Error creating account:', error);
    }
  };

  const deposit = async () => {
    try {
      await fetch(`http://localhost:8080/api/accounts/deposit`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ amount: parseFloat(amount) }),
      });
      fetchAccounts();
    } catch (error) {
      console.error('Error depositing:', error);
    }
  };

  const withdraw = async () => {
    try {
      await fetch(`http://localhost:8080/api/accounts/withdraw`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ amount: parseFloat(amount) }),
      });
      fetchAccounts();
    } catch (error) {
      console.error('Error withdrawing:', error);
    }
  };

  const transfer = async () => {
    try {
      await fetch(`http://localhost:8080/api/accounts/transfer`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ receiverID: parseInt(receiverId), amount: parseFloat(amount) }),
      });
      fetchAccounts();
    } catch (error) {
      console.error('Error transferring:', error);
    }
  };

  return (
    <div className="App">
      <h1>Bank Account Management</h1>

      <div>
        <h2>Create Account</h2>
        <input
          type="number"
          placeholder="Account ID"
          value={accountId}
          onChange={(e) => setAccountId(e.target.value)}
        />
        <button onClick={createAccount}>Create Account</button>
      </div>

      <div>
        <h2>Deposit/Withdraw</h2>
        <input
          type="number"
          placeholder="Account ID"
          value={accountId}
          onChange={(e) => setAccountId(e.target.value)}
        />
        <input
          type="number"
          placeholder="Amount"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
        <button onClick={deposit}>Deposit</button>
        <button onClick={withdraw}>Withdraw</button>
      </div>

      <div>
        <h2>Transfer</h2>
        <input
          type="number"
          placeholder="Sender Account ID"
          value={accountId}
          onChange={(e) => setAccountId(e.target.value)}
        />
        <input
          type="number"
          placeholder="Receiver Account ID"
          value={receiverId}
          onChange={(e) => setReceiverId(e.target.value)}
        />
        <input
          type="number"
          placeholder="Amount"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
        <button onClick={transfer}>Transfer</button>
      </div>

      <div>
        <h2>All Accounts</h2>
        <ul>
          {accounts.map((account) => (
            <li key={account.id}>
              ID: {account.id}, Balance: {account.kontostand}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;