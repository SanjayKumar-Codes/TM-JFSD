import React from "react";
import { FoodItem } from "../types";

interface Props {
  cart: FoodItem[];
}

const Cart: React.FC<Props> = ({ cart }) => {
  return (
    <div className="container mt-4">
      <h2 className="text-center mb-3">Your Cart</h2>
      {cart.length === 0 ? (
        <p className="text-center">No items in cart.</p>
      ) : (
        <ul className="list-group">
          {cart.map((item, index) => (
            <li key={index} className="list-group-item d-flex justify-content-between align-items-center">
              <span>{item.name}</span>
              <strong>${item.price.toFixed(2)}</strong>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Cart;
