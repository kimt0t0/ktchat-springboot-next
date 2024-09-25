import '@testing-library/jest-dom';
import { render, screen } from "@testing-library/react";
import test from 'node:test';
import NavLinks from './nav-links';

test('renders navigation links', () => {
    render(<NavLinks />);
    
    const homeLink = screen.getByText(/Accueil/i);
    const tchatLink = screen.getByText(/Tchat/i);
    const authLink = screen.getByText(/Connexion\/Inscription/i);

    expect(homeLink).toBeInTheDocument();
    expect(tchatLink).toBeInTheDocument();
    expect(authLink).toBeInTheDocument();
});
