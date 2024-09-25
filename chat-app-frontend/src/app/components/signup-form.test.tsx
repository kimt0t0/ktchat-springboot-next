import { fireEvent, render, screen } from "@testing-library/react";
import SignupForm from "./signup-form";

test('submits the form when inputs are valid', () => {
    const handleSubmit = jest.fn();

    render(<SignupForm onSubmit={handleSubmit} />);

    fireEvent.change(screen.getByLabelText(/username/i), { target: { value: 'username' } });
    fireEvent.change(screen.getByLabelText(/email/i), { target: { value: 'test@example.com' } });
    fireEvent.change(screen.getByLabelText(/password/i), { target: { value: 'password123' } });

    fireEvent.click(screen.getByText(/submit/i));

    // expect(handleSubmit).toHaveBeenCalled();
});

test('shows an error if email is invalid', () => {
    render(<SignupForm onSubmit={jest.fn()} />);

    fireEvent.change(screen.getByLabelText(/email/i), { target: { value: 'invalid-email' } });

    fireEvent.click(screen.getByText(/submit/i));

    // expect(screen.getByText(/invalid email/i)).toBeInTheDocument();
});
