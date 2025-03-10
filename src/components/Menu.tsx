import React, { useEffect, useState } from "react";
import { FoodItem } from "../types";
import foodData from "../data/foodData.json";
import Puttu from ""

interface Props {
  addToCart: (food: FoodItem) => void;
}

const Menu: React.FC<Props> = ({ addToCart }) => {
  const [menu, setMenu] = useState<FoodItem[]>([]);

  useEffect(() => {
    setMenu(foodData);
  }, []);

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Our Menu</h2>
      <div className="row">
        {menu.map((food) => (
          <div key={food.id} className="col-md-4">
            <div className="card mb-4">
              <img src={food.image} className="card-img-top" alt={food.name} />
              <div className="card-body text-center">
                <h5 className="card-title">{food.name}</h5>
                <p className="card-text">{food.description}</p>
                <p className="card-text"><strong>${food.price.toFixed(2)}</strong></p>
                <button className="btn btn-primary" onClick={() => addToCart(food)}>
                  Add to Cart
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Menu;
