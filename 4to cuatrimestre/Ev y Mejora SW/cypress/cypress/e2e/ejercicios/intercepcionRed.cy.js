it('Intercepta y modifica una solicitud de red', () => {
    cy.visit('https://example.cypress.io/commands/network-requests')
    cy.intercept('GET', '**/comments/*').as('getComment')
    cy.get('.network-btn').click()
    cy.wait('@getComment').its('response.statusCode').should('be.oneOf', [200, 304])
})