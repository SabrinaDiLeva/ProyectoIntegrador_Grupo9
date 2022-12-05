import React from 'react';
import '@testing-library/jest-dom/extend-expect';
import { render, screen } from '@testing-library/react';
import Footer from '../components/footer/footer';
import Header from '../components/Header/Header';
import Login from '../components/login/login';
import Register from '../components/Register/register';
import Listado from '../components/Listado/Card';
import Buscador from '../components/Bloque-buscador/Buscador';

describe('Probar componentes de encabezado y pie de pagina', () =>{
    describe('Probar el componente footer', () =>{
        test('Texto que existe en el footer', () => {
            render(<Footer/>);
            const cont = screen.getByText('2022 Digital Booking');
            expect(cont).toBeInTheDocument();
    
        })

    })
    describe('Probar el componente header', () =>{
        test('Texto que existe en el header', () => {
            render(<Header/>);
            const cont = screen.getByText('Iniciar Sesion');
            expect(cont).toBeInTheDocument();
    
        })

    })
    
})
describe('Probar componentes de login y register', () =>{
    describe('Probar el componente login', () =>{
        test('Texto que existe en el login', () => {
            render(<Login/>);
            const cont = screen.getByText('Iniciar sesión');
            expect(cont).toBeInTheDocument();
    
        })

    })
    describe('Probar el componente register', () =>{
        test('Texto que existe en el register', () => {
            render(<Register/>);
            const cont = screen.getByText('Crear cuenta');
            expect(cont).toBeInTheDocument();
    
        })

    })
    
})
describe('Probar componentes de Listado', () =>{
    describe('Probar el componente Listado', () =>{
        test('Texto que existe en el Listado', () => {
            render(<Listado/>);
            const cont = screen.getByText('Ver detalle');
            const cont1 = screen.getByText('Ver Mas')
            expect(cont).toBeInTheDocument();
            expect(cont1).toBeInTheDocument();
    
        })

    })
    
})
describe('Probar componentes de buscar', () =>{
    describe('Probar el componente buscar', () =>{
        test('Texto que existe en el buscar', () => {
            render(<Buscador/>);
            const cont = screen.getByText('Busca ofertas en hoteles, casas y mucho mas...') 
            expect(cont).toBeInTheDocument();
    
        })

    })
    
})