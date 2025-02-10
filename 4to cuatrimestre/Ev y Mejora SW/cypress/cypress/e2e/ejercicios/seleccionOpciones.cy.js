it('Selecciona opciones de un select', () => {
  cy.visit('https://example.cypress.io/commands/actions')
  cy.get('.action-select')
  .select('apples')
  .should('have.value', 'fr-apples')
})