import React, { useState } from "react";
import OrderForm from "../components/OrderForm";
import { FoodItem } from "../types";

interface Props {
  cart: FoodItem[];
  setCart: React.Dispatch<React.SetStateAction<FoodItem[]>>;
}

const CartPage: React.FC<Props> = ({ cart, setCart }) => {
  const updateQuantity = (id: number, change: number) => {
    setCart((prevCart) =>
      prevCart
        .map((item) =>
          item.id === id ? { ...item, quantity: Math.max(1, (item.quantity || 1) + change) } : item
        )
        .filter((item) => item.quantity! > 0) // Remove item if quantity is 0
    );
  };

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">🛒 Your Cart</h2>
      {cart.length === 0 ? (
        <p className="text-center">Your cart is empty.</p>
      ) : (
        <ul className="list-group">
          {cart.map((item) => (
            <li key={item.id} className="list-group-item d-flex justify-content-between align-items-center">
              <div>
                <img src={item.image} alt={item.name} style={{ width: "50px", marginRight: "10px" }} />
                {item.name} - <strong>${(item.price * (item.quantity || 1)).toFixed(2)}</strong>
              </div>
              <div>
                <button className="btn btn-sm btn-outline-danger" onClick={() => updateQuantity(item.id, -1)}>-</button>
                <span className="mx-2">{item.quantity || 1}</span>
                <button className="btn btn-sm btn-outline-success" onClick={() => updateQuantity(item.id, 1)}>+</button>
              </div>
            </li>
          ))}
        </ul>
      )}
      {cart.length > 0 && <OrderForm />}
    </div>
  );
};

export default CartPage;
