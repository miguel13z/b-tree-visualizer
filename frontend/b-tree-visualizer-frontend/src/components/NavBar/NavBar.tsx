import "./NavBar.css"
import graphIcon from '../../assets/icon/graph-icon.png';

function NavBar() {
    return (
        <nav className="navbar">
            <img src={graphIcon} alt="Ícone da Árvore" className="nav-icon"/>
            B-Tree Visualizer
        </nav>
    )
}

export default NavBar;