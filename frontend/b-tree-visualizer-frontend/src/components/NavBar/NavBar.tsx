import "./NavBar.css"
import graphIcon from '../../assets/icon/graph-icon.png';

function NavBar() {
    return (
        <nav className="navbar">
            <img src={graphIcon} alt="Ícone da Árvore" className="nav-icon"/>

            <span>B-Tree Visualizer</span>

            <ul className="ul-navbar">
                <li><a href="/">About</a></li>
                <li><a href="/">Home</a></li>
            </ul>
        </nav>
    )
}

export default NavBar;