it('Marca y desmarca checkbox', () => {
    cy.visit('https://example.cypress.io/commands/actions')
    cy.get('.action-checkboxes [type="checkbox"]').first().check()
    cy.get('.action-checkboxes [type="checkbox"]').first().should('be.checked')
})