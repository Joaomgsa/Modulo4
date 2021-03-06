import React from 'react';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

import { FiShoppingBag } from 'react-icons/fi';
import './styles.css';

import logo from '../../assets/airplane.png';

export default function Header() {;
  const cartSize = useSelector(state => state.cart.length);
  return (
    <header className="header">
      <Link to="/" className="logo">
        <img className="logo-icon" src={logo} alt="Rocketshoes" />
        <span className="logo-text">Minha Viagem</span>
      </Link>

      <Link to="/cart" className="header-cart">
        <div>
          <strong>Meus cupons</strong>
          <span>
            <strong>{cartSize}</strong> passagens
          </span>
        </div>
        <FiShoppingBag size={36} color="#FFF" />
      </Link>
    </header>
  );
}