import "./Footer.css";

function Footer() {
    return (
        <footer className="footer">
            <span>B-Tree Visualizer - Computação@UFCG</span>
            <span className="separator">|</span>
            <span className="credits">
                Desenvolvido por <a href="https://github.com/phdeandrade" target="_blank" rel="noopener noreferrer">Pedro Andrade</a> & <a href="https://github.com/miguel13z" target="_blank" rel="noopener noreferrer">Miguel Melo</a>
            </span>
        </footer>
    )
}

export default Footer;