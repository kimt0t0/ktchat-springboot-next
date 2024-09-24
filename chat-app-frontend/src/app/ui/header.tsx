import { Suspense } from "react";
import NavLinks from "./nav-links";

export default function Header () {
    return (
        <Suspense fallback={<div>Loading...</div>}>
            <header>
                <h1>KTchat !</h1>
                <NavLinks />
            </header>
        </Suspense>
    )
}