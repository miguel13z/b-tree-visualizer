import { type ReactNode } from 'react';
import NavBar from "../NavBar/NavBar"
import Footer from '../Footer/Footer';

interface LayoutProps {
    children: ReactNode;
}

function Layout({ children }: LayoutProps) {
    return (
        <>
        <NavBar />

        <main>
            {children}
        </main>

        <Footer />
        </>
    );
}

export default Layout;