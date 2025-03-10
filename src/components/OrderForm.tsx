import React, { useState } from "react";

const OrderForm: React.FC = () => {
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    alert(`Order placed for ${name}, Address: ${address}`);
  };

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-3">Place Your Order</h2>
      <form onSubmit={handleSubmit} className="border p-4 rounded bg-white shadow-sm">
        <div className="mb-3">
          <label className="form-label">Name</label>
          <input
            type="text"
            className="form-control"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Address</label>
          <input
            type="text"
            className="form-control"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-success w-100">
          Place Order
        </button>
      </form>
    </div>
  );
};

export default OrderForm;
