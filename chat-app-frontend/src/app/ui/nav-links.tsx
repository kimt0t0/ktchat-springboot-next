"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";
import { useEffect, useState } from "react";

const NavLinks = () => {
    const pathname = usePathname();
    const [isMounted, setIsMounted] = useState(false);
    useEffect(() => {
        setIsMounted(true)
    }, []);

    if (!isMounted) {
        return null
    }

    return(
        <nav>
            <Link className={`link ${pathname === '/' ? 'active' : ''}`} href="/">Accueil</Link>
            <Link className={`link ${pathname === '/tchat' ? 'active' : ''}`} href="/tchat">Tchat</Link>
            <Link className={`link ${pathname === '/auth' ? 'active' : ''}`} href="/auth">Connexion/Inscription</Link>
        </nav>
    )
}
export default NavLinks;