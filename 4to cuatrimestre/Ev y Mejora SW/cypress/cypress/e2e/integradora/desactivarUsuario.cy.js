describe('Practica Integradora', () => {
    before(() => {
        cy.visit('http://localhost:8080/');
    });

    it('Desactivar un usuario', () => {
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

        cy.url().should('not.eq', 'http://localhost:8080/');

        cy.get('#esconderBTN').should('be.visible').click();
        cy.get('a[href="/user/list-users"]').should('be.visible').click();

        cy.get('[data-id="2"]').should('be.visible').click();

        cy.screenshot('SanchezPerezMiguel_desactivarUsuario1')
        cy.get('button.swal2-confirm')
            .should('have.class', 'swal2-styled')
            .and('be.visible')
            .click();
        cy.wait(500)
        cy.screenshot('SanchezPerezMiguel_desactivarUsuario2')
    });
})
