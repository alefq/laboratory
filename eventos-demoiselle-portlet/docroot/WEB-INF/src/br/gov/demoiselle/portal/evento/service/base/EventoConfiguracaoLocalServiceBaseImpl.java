/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.gov.demoiselle.portal.evento.service.base;

import br.gov.demoiselle.portal.evento.model.EventoConfiguracao;
import br.gov.demoiselle.portal.evento.service.EventoConfiguracaoLocalService;
import br.gov.demoiselle.portal.evento.service.EventoConviteLocalService;
import br.gov.demoiselle.portal.evento.service.EventoParticipanteLocalService;
import br.gov.demoiselle.portal.evento.service.persistence.EventoConfiguracaoPersistence;
import br.gov.demoiselle.portal.evento.service.persistence.EventoConvitePersistence;
import br.gov.demoiselle.portal.evento.service.persistence.EventoParticipantePersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the evento configuracao local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link br.gov.demoiselle.portal.evento.service.impl.EventoConfiguracaoLocalServiceImpl}.
 * </p>
 *
 * @author Clovis Lemes Ferreira Junior
 * @see br.gov.demoiselle.portal.evento.service.impl.EventoConfiguracaoLocalServiceImpl
 * @see br.gov.demoiselle.portal.evento.service.EventoConfiguracaoLocalServiceUtil
 * @generated
 */
public abstract class EventoConfiguracaoLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements EventoConfiguracaoLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link br.gov.demoiselle.portal.evento.service.EventoConfiguracaoLocalServiceUtil} to access the evento configuracao local service.
	 */

	/**
	 * Adds the evento configuracao to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoConfiguracao the evento configuracao
	 * @return the evento configuracao that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EventoConfiguracao addEventoConfiguracao(
		EventoConfiguracao eventoConfiguracao) throws SystemException {
		eventoConfiguracao.setNew(true);

		return eventoConfiguracaoPersistence.update(eventoConfiguracao, false);
	}

	/**
	 * Creates a new evento configuracao with the primary key. Does not add the evento configuracao to the database.
	 *
	 * @param eventoConfiguracaoId the primary key for the new evento configuracao
	 * @return the new evento configuracao
	 */
	public EventoConfiguracao createEventoConfiguracao(
		long eventoConfiguracaoId) {
		return eventoConfiguracaoPersistence.create(eventoConfiguracaoId);
	}

	/**
	 * Deletes the evento configuracao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoConfiguracaoId the primary key of the evento configuracao
	 * @return the evento configuracao that was removed
	 * @throws PortalException if a evento configuracao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public EventoConfiguracao deleteEventoConfiguracao(
		long eventoConfiguracaoId) throws PortalException, SystemException {
		return eventoConfiguracaoPersistence.remove(eventoConfiguracaoId);
	}

	/**
	 * Deletes the evento configuracao from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoConfiguracao the evento configuracao
	 * @return the evento configuracao that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public EventoConfiguracao deleteEventoConfiguracao(
		EventoConfiguracao eventoConfiguracao) throws SystemException {
		return eventoConfiguracaoPersistence.remove(eventoConfiguracao);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(EventoConfiguracao.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return eventoConfiguracaoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return eventoConfiguracaoPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return eventoConfiguracaoPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return eventoConfiguracaoPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public EventoConfiguracao fetchEventoConfiguracao(long eventoConfiguracaoId)
		throws SystemException {
		return eventoConfiguracaoPersistence.fetchByPrimaryKey(eventoConfiguracaoId);
	}

	/**
	 * Returns the evento configuracao with the primary key.
	 *
	 * @param eventoConfiguracaoId the primary key of the evento configuracao
	 * @return the evento configuracao
	 * @throws PortalException if a evento configuracao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventoConfiguracao getEventoConfiguracao(long eventoConfiguracaoId)
		throws PortalException, SystemException {
		return eventoConfiguracaoPersistence.findByPrimaryKey(eventoConfiguracaoId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return eventoConfiguracaoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the evento configuracaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of evento configuracaos
	 * @param end the upper bound of the range of evento configuracaos (not inclusive)
	 * @return the range of evento configuracaos
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventoConfiguracao> getEventoConfiguracaos(int start, int end)
		throws SystemException {
		return eventoConfiguracaoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of evento configuracaos.
	 *
	 * @return the number of evento configuracaos
	 * @throws SystemException if a system exception occurred
	 */
	public int getEventoConfiguracaosCount() throws SystemException {
		return eventoConfiguracaoPersistence.countAll();
	}

	/**
	 * Updates the evento configuracao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventoConfiguracao the evento configuracao
	 * @return the evento configuracao that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EventoConfiguracao updateEventoConfiguracao(
		EventoConfiguracao eventoConfiguracao) throws SystemException {
		return updateEventoConfiguracao(eventoConfiguracao, true);
	}

	/**
	 * Updates the evento configuracao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventoConfiguracao the evento configuracao
	 * @param merge whether to merge the evento configuracao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the evento configuracao that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EventoConfiguracao updateEventoConfiguracao(
		EventoConfiguracao eventoConfiguracao, boolean merge)
		throws SystemException {
		eventoConfiguracao.setNew(false);

		return eventoConfiguracaoPersistence.update(eventoConfiguracao, merge);
	}

	/**
	 * Returns the evento configuracao local service.
	 *
	 * @return the evento configuracao local service
	 */
	public EventoConfiguracaoLocalService getEventoConfiguracaoLocalService() {
		return eventoConfiguracaoLocalService;
	}

	/**
	 * Sets the evento configuracao local service.
	 *
	 * @param eventoConfiguracaoLocalService the evento configuracao local service
	 */
	public void setEventoConfiguracaoLocalService(
		EventoConfiguracaoLocalService eventoConfiguracaoLocalService) {
		this.eventoConfiguracaoLocalService = eventoConfiguracaoLocalService;
	}

	/**
	 * Returns the evento configuracao persistence.
	 *
	 * @return the evento configuracao persistence
	 */
	public EventoConfiguracaoPersistence getEventoConfiguracaoPersistence() {
		return eventoConfiguracaoPersistence;
	}

	/**
	 * Sets the evento configuracao persistence.
	 *
	 * @param eventoConfiguracaoPersistence the evento configuracao persistence
	 */
	public void setEventoConfiguracaoPersistence(
		EventoConfiguracaoPersistence eventoConfiguracaoPersistence) {
		this.eventoConfiguracaoPersistence = eventoConfiguracaoPersistence;
	}

	/**
	 * Returns the evento convite local service.
	 *
	 * @return the evento convite local service
	 */
	public EventoConviteLocalService getEventoConviteLocalService() {
		return eventoConviteLocalService;
	}

	/**
	 * Sets the evento convite local service.
	 *
	 * @param eventoConviteLocalService the evento convite local service
	 */
	public void setEventoConviteLocalService(
		EventoConviteLocalService eventoConviteLocalService) {
		this.eventoConviteLocalService = eventoConviteLocalService;
	}

	/**
	 * Returns the evento convite persistence.
	 *
	 * @return the evento convite persistence
	 */
	public EventoConvitePersistence getEventoConvitePersistence() {
		return eventoConvitePersistence;
	}

	/**
	 * Sets the evento convite persistence.
	 *
	 * @param eventoConvitePersistence the evento convite persistence
	 */
	public void setEventoConvitePersistence(
		EventoConvitePersistence eventoConvitePersistence) {
		this.eventoConvitePersistence = eventoConvitePersistence;
	}

	/**
	 * Returns the evento participante local service.
	 *
	 * @return the evento participante local service
	 */
	public EventoParticipanteLocalService getEventoParticipanteLocalService() {
		return eventoParticipanteLocalService;
	}

	/**
	 * Sets the evento participante local service.
	 *
	 * @param eventoParticipanteLocalService the evento participante local service
	 */
	public void setEventoParticipanteLocalService(
		EventoParticipanteLocalService eventoParticipanteLocalService) {
		this.eventoParticipanteLocalService = eventoParticipanteLocalService;
	}

	/**
	 * Returns the evento participante persistence.
	 *
	 * @return the evento participante persistence
	 */
	public EventoParticipantePersistence getEventoParticipantePersistence() {
		return eventoParticipantePersistence;
	}

	/**
	 * Sets the evento participante persistence.
	 *
	 * @param eventoParticipantePersistence the evento participante persistence
	 */
	public void setEventoParticipantePersistence(
		EventoParticipantePersistence eventoParticipantePersistence) {
		this.eventoParticipantePersistence = eventoParticipantePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("br.gov.demoiselle.portal.evento.model.EventoConfiguracao",
			eventoConfiguracaoLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"br.gov.demoiselle.portal.evento.model.EventoConfiguracao");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return EventoConfiguracao.class;
	}

	protected String getModelClassName() {
		return EventoConfiguracao.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = eventoConfiguracaoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = EventoConfiguracaoLocalService.class)
	protected EventoConfiguracaoLocalService eventoConfiguracaoLocalService;
	@BeanReference(type = EventoConfiguracaoPersistence.class)
	protected EventoConfiguracaoPersistence eventoConfiguracaoPersistence;
	@BeanReference(type = EventoConviteLocalService.class)
	protected EventoConviteLocalService eventoConviteLocalService;
	@BeanReference(type = EventoConvitePersistence.class)
	protected EventoConvitePersistence eventoConvitePersistence;
	@BeanReference(type = EventoParticipanteLocalService.class)
	protected EventoParticipanteLocalService eventoParticipanteLocalService;
	@BeanReference(type = EventoParticipantePersistence.class)
	protected EventoParticipantePersistence eventoParticipantePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private EventoConfiguracaoLocalServiceClpInvoker _clpInvoker = new EventoConfiguracaoLocalServiceClpInvoker();
}