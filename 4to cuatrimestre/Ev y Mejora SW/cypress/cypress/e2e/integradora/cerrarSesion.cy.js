describe('Practica Integradora', () => {
    before(() => {
        cy.visit('http://localhost:8080/');
    });

    it('Cerrar sesión', () => {
        cy.get('#email')
            .should('be.visible')
            .type('alejandro@correo.com')
            .should('have.value', 'alejandro@correo.com');

        cy.get('#password')
            .should('be.visible')
            .type('alejandro@correo.com')
            .should('have.value', 'alejandro@correo.com');

        cy.get('.botonLogin')
            .should('be.visible')
            .click();

        cy.get('#esconderBTN').should('be.visible').click();
        cy.get('a[href="/LogoutServlet"]').should('be.visible').click();-

        cy.get('button.swal2-confirm')
            .should('have.class', 'swal2-styled')
            .and('be.visible')
            .click();
    });
})
