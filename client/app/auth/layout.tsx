import { Roboto } from 'next/font/google';
import '../globals.css';

const roboto = Roboto({
  subsets: ['latin'],
  weight: ['400', '700'],
  variable: '--font-roboto',
});

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={`${roboto.variable} antialiased`}>
        <div className="h-screen flex justify-center items-center">
          {children}
        </div>
      </body>
    </html>
  );
}
