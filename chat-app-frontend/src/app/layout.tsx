import { Suspense } from "react";
import "./globals.css";
import Footer from "./ui/footer";
import Header from "./ui/header";

export default function RootLayout({
    children,
}: {
    children: React.ReactNode;
}) {
    return (
    <html lang="fr">
        <body>
            <Suspense fallback={<div>Loading...</div>}>
                <Header></Header>
            </Suspense>
                <main>
                    {children}
                </main>
            <Footer></Footer>
        </body>
    </html>
    );
}
