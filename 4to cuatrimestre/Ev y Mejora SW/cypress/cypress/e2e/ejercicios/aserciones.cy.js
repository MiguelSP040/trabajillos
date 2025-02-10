it('Verifica el contenido y atributos', () => {
    cy.visit('https://example.cypress.io/commands/assertions')
    cy.get('.assertion-table')
    .find('tbody tr:last')
    .should('have.class', 'success')
    .find('td')
    .first()
    .should('have.text', 'Column content')
})