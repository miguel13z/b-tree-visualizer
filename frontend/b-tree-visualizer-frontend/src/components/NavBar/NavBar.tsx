import { Link } from 'react-router-dom';
import "./NavBar.css"
import graphIcon from '../../assets/icon/graph-icon.png';

function NavBar() {
    return (
        <nav className="navbar">
            <img src={graphIcon} alt="Ícone da Árvore" className="nav-icon"/>

            <span>B-Tree Visualizer</span>

            <ul className="ul-navbar">
                <li><Link to="/about">About</Link></li>
                <li><Link to="/">Home</Link></li>
            </ul>
        </nav>
    )
}

export default NavBar;