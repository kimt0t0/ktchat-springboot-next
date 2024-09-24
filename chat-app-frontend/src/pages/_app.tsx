import RootLayout from "@/app/layout";
import { AppProps } from "next/app";

function KTchatApp({ Component, pageProps } : AppProps) {
    return (
        <RootLayout>
            <Component {...pageProps} />
        </RootLayout>
    )
}

export default KTchatApp;