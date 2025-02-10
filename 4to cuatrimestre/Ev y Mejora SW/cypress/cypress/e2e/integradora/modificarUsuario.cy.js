describe('Modificar información de un usuario', () => {
    it('Abre el modal y modifica los datos del usuario', () => {
        cy.visit('http://localhost:8080/');

        // Iniciar sesión
        cy.get('#email').type('alejandro@correo.com');
        cy.get('#password').type('alejandro@correo.com');
        cy.get('.botonLogin').click();

        // Navegar a la lista de usuarios
        cy.get('#esconderBTN').click();
        cy.get('a[href="/user/list-users"]').should('be.visible').click();

        // Localizar el botón de editar en la fila del usuario
        cy.get('th[scope="row"]').contains('2')
            .parents('tr')
            .find('.botonEditar')
            .should('be.visible')
            .click();
        cy.wait(1000)

        // Modificar los campos dentro del modal
        cy.get('#updateUser input[name="name"]').clear({ force: true }).type('Danna Paola', { force: true });
        cy.get('#updateUser input[name="lastname"]').clear({ force: true }).type('Martínez', { force: true });
        cy.get('#updateUser input[name="phone"]').clear({ force: true }).type('7773546455', { force: true });


        // Guardar cambios
        cy.get('#updateUser button[type="submit"]').click();
        cy.wait(500)

        // Confirmar el SweetAlert
        cy.get('button.swal2-confirm').click();
    });
});
