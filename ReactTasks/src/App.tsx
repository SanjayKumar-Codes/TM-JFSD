import React, { useState } from "react";
import { Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import Menu from "./components/Menu";
import CartPage from "./components/CartPage";
import { FoodItem } from "./types";

const App: React.FC = () => {
  const [cart, setCart] = useState<FoodItem[]>([]);

  const addToCart = (food: FoodItem) => {
    setCart((prevCart) => {
      const existingItem = prevCart.find((item) => item.id === food.id);
      if (existingItem) {
        return prevCart.map((item) =>
          item.id === food.id ? { ...item, quantity: (item.quantity || 1) + 1 } : item
        );
      }
      return [...prevCart, { ...food, quantity: 1 }];
    });
  };

  return (
    <div className="App">
      <Navbar />
      <Routes>
        <Route path="/" element={<Menu addToCart={addToCart} />} />
        <Route path="/cart" element={<CartPage cart={cart} setCart={setCart} />} />
      </Routes>
      <Footer />
    </div>
  );
};

export default App;
