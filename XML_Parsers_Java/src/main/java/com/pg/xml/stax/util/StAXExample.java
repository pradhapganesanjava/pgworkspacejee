package com.pg.xml.stax.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXExample {
	/* Constant(s): */
	private final static String KOMPIS_XML_FILE_NAME = "kompisar.xml";
	private final static String KOMPIS_NOERR_XML_FILE_NAME = "kompisar_noerrors.xml";
	private final static String ONE_TAB = " ";
	private final static String XML_ITERATOR_OUTPUT_FILE = "stax_iterator_output.xml";
	private final static String XML_CURSOR_OUTPUT_FILE = "stax_cursor_output.xml";

	/* Instance variable(s): */
	/**
	 * Program main entry point.
	 * 
	 * @param args
	 *            Command line arguments, ignored.
	 */
	public static void main(final String[] args) {
		final StAXExample theExample = new StAXExample();
		try {
			theExample.readWriteWithCursor();
		} catch (final Exception theException) {
			theException.printStackTrace();
		}
	}

	private void printTab(final int inTabs) {
		for (int i = 0; i < inTabs; i++) {
			System.out.print(ONE_TAB);
		}
	}

	/**
	 * Reads an XML file using the StAX iterator API and prints data for some of
	 * the event types.
	 * 
	 * @throws Exception
	 *             If error occurs reading file.
	 */
	public void readWithIterator() throws Exception {
		int theTab = 0;
		System.out.println("***** Reading XML file using the StAX Iterator API:");
		/*
		 * Retrieve a factory that can create both StAX event and stream
		 * readers.
		 */
		final XMLInputFactory theFactory = XMLInputFactory.newInstance();
		/*
		 * Create an event reader, also called an iterator, for reading the
		 * example XML document.
		 */
		final FileInputStream theFileIS = new FileInputStream(KOMPIS_XML_FILE_NAME);
		final XMLEventReader theXMLIterator = theFactory.createXMLEventReader(theFileIS);

		while (theXMLIterator.hasNext()) {
			final XMLEvent theEvent = theXMLIterator.nextEvent();
			switch (theEvent.getEventType()) {
			case XMLStreamConstants.CHARACTERS:
				final String theCharacters = theEvent.asCharacters().toString().trim();
				if (theCharacters.length() > 0) {
					printTab(theTab);
					System.out.println("Characters event: " + theCharacters);
				}
				break;
			case XMLStreamConstants.COMMENT:
				printTab(theTab);
				System.out.println("Comment event: " + theEvent.toString());
				break;
			case XMLStreamConstants.END_DOCUMENT:
				printTab(theTab);
				System.out.println("End of document event.");
				break;
			case XMLStreamConstants.END_ELEMENT:
				printTab(--theTab);
				final EndElement theEndElement = theEvent.asEndElement();
				System.out.println("End of element: " + theEndElement.getName());
				break;
			case XMLStreamConstants.NAMESPACE:
				printTab(theTab);
				System.out.println("Namespace event: " + theEvent.asCharacters());
				break;
			case XMLStreamConstants.START_DOCUMENT:
				printTab(theTab);
				System.out.println("Start of document");
				break;
			case XMLStreamConstants.START_ELEMENT:
				printTab(theTab++);
				final StartElement theStartElement = theEvent.asStartElement();
				System.out.print("Start of element: " + theStartElement.getName());
				/* List all the attributes, if any. */
				final Iterator<Attribute> theAttrIter = theStartElement.getAttributes();
				if (theAttrIter.hasNext()) {
					System.out.print(", attributes: ");
				}
				while (theAttrIter.hasNext()) {
					final Attribute theAttribute = theAttrIter.next();
					System.out.print(theAttribute.getName() + "=" + theAttribute.getValue());
					if (theAttrIter.hasNext()) {
						System.out.print(", ");
					}
				}
				System.out.println("");
				break;
			default:
				printTab(theTab);
				System.out.println("Unrecognized event: " + theEvent.getEventType());
			}
		}
	}

	/**
	 * Reads an XML file using the StAX stream API and prints data for some of
	 * the event types.
	 * 
	 * @throws Exception
	 *             If error occurs reading file.
	 */
	public void readWithCursor() throws Exception {
		int theTab = 0;
		System.out.println("***** Reading XML file using the StAX Cursor API:");
		/*
		 * Retrieve a factory that can create both StAX event and stream
		 * readers.
		 */
		final XMLInputFactory theFactory = XMLInputFactory.newInstance();
		/*
		 * Create a stream reader, also called an cursor, for reading the
		 * example XML document.
		 */
		final FileInputStream theFileIS = new FileInputStream(KOMPIS_XML_FILE_NAME);
		final XMLStreamReader theXMLCursor = theFactory.createXMLStreamReader(theFileIS);
		while (theXMLCursor.hasNext()) {
			final int theEventCode = theXMLCursor.next();
			switch (theEventCode) {
			case XMLStreamConstants.CHARACTERS:
				final String theCharacters = theXMLCursor.getText().trim();
				if (theCharacters.length() > 0) {
					printTab(theTab);
					System.out.println("Characters event: " + theCharacters);
				}
				break;
			case XMLStreamConstants.COMMENT:
				printTab(theTab);
				System.out.println("Comment event: " + theXMLCursor.getText());
				break;
			case XMLStreamConstants.END_DOCUMENT:
				printTab(theTab);
				System.out.println("End of document event.");
				break;
			case XMLStreamConstants.END_ELEMENT:
				printTab(--theTab);
				System.out.println("End of element: " + theXMLCursor.getLocalName());
				break;
			case XMLStreamConstants.NAMESPACE:
				printTab(theTab);
				System.out.println("Namespace event: ");
				break;
			case XMLStreamConstants.START_DOCUMENT:
				printTab(theTab);
				System.out.println("Start of document");
				break;
			case XMLStreamConstants.START_ELEMENT:
				printTab(theTab++);
				System.out.print("Start of element: " + theXMLCursor.getLocalName());
				/* List all the attributes, if any. */
				final int theAttributeCount = theXMLCursor.getAttributeCount();
				if (theAttributeCount > 0) {
					System.out.print(", attributes: ");
				}
				for (int i = 0; i < theAttributeCount; i++) {
					System.out.print(theXMLCursor.getAttributeLocalName(i) + "="
							+ theXMLCursor.getAttributeValue(i));
					if ((i + 1) < theAttributeCount) {
						System.out.print(", ");
					}
				}
				System.out.println();
				break;
			default:
				printTab(theTab);
				System.out.println("Unrecognized event: " + theEventCode);
			}
		}
	}

	/**
	 * Reads an XML file using the StAX iterator API and and writes it, also
	 * using the StAX iterator API, to an output file. Some additional
	 * processing will be done before the data is written.
	 * 
	 * @throws Exception
	 *             If error occurs reading file.
	 */
	public void readWriteWithIterator() throws Exception {
		System.out.println("***** Read and write XML using the StAX Iterator API:");
		/*
		 * Retrieve factories that can create both StAX event and stream readers
		 * and writers.
		 */
		final XMLInputFactory theInputFactory = XMLInputFactory.newInstance();
		final XMLOutputFactory theOutputFactory = XMLOutputFactory.newInstance();
		/* Create a factory that can create XML events. */
		final XMLEventFactory theEventFactory = XMLEventFactory.newInstance();
		/*
		 * Create an event reader, also called an iterator, for reading the
		 * example XML document.
		 */
		final FileInputStream theFileIS = new FileInputStream(KOMPIS_XML_FILE_NAME);
		final XMLEventReader theXMLIterator = theInputFactory.createXMLEventReader(theFileIS);
		/* Create an event writer in order to write to a file. */
		final FileOutputStream theFOS = new FileOutputStream(XML_ITERATOR_OUTPUT_FILE);
		final XMLEventWriter theXMLWriter = theOutputFactory.createXMLEventWriter(theFOS);
		while (theXMLIterator.hasNext()) {
			final XMLEvent theEvent = theXMLIterator.nextEvent();
			switch (theEvent.getEventType()) {
			case XMLStreamConstants.CHARACTERS: {
				/* Change all character data to uppercase only. */
				XMLEvent theNewEvent;
				String theOriginalCharacters;
				theOriginalCharacters = theEvent.asCharacters().getData().trim();
				if (theOriginalCharacters.length() > 0) {
					theNewEvent = theEventFactory.createCharacters(theOriginalCharacters.toUpperCase());
					theXMLWriter.add(theNewEvent);
				}
				break;
			}
			case XMLStreamConstants.COMMENT: {
				/* Reverse the text of all comments. */
				XMLEvent theNewEvent;
				StringBuffer theComment;
				theComment = new StringBuffer(theEvent.toString());
				theComment.reverse();
				theNewEvent = theEventFactory.createComment(theComment.toString());
				theXMLWriter.add(theNewEvent);
				break;
			}
			case XMLStreamConstants.END_DOCUMENT:
				theXMLWriter.add(theEvent);
				break;
			case XMLStreamConstants.END_ELEMENT:
				theXMLWriter.add(theEvent);
				break;
			case XMLStreamConstants.NAMESPACE:
				System.err.println("A namespace event was ignored");
				break;
			case XMLStreamConstants.START_DOCUMENT:
				theXMLWriter.add(theEvent);
				break;
			case XMLStreamConstants.START_ELEMENT:
				Attribute theNewAttribute;
				theXMLWriter.add(theEvent);
				/* Add a new attribute to all elements. */
				theNewAttribute = theEventFactory.createAttribute("newAttribute", "someValue");
				theXMLWriter.add(theNewAttribute);
				break;
			default:
				System.err.println("Unrecognized event was ignored: " + theEvent.getEventType());
				break;
			}
		}
		theFOS.close();
	}

	/**
	 * Reads an XML file using the StAX stream API and and writes it, also using
	 * the StAX stream API, to an output file. Some additional processing will
	 * be done before the data is written.
	 * 
	 * @throws Exception
	 *             If error occurs reading file.
	 */
	public void readWriteWithCursor() throws Exception {
		System.out.println("***** Reading and writing XML file using the StAX Cursor API:");
		(new File(XML_CURSOR_OUTPUT_FILE)).delete();
		/*
		 * Retrieve factories that can create both StAX event and stream readers
		 * and writers. If we set the IS_REPAIRING_NAMESPACES property to true,
		 * the correct namespace declarations will automatically be present in
		 * the output file.
		 */
		final XMLInputFactory theInputFactory = XMLInputFactory.newInstance();
		final XMLOutputFactory theOutputFactory = XMLOutputFactory.newInstance();
		theOutputFactory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, Boolean.TRUE);
		/*
		 * Create a stream reader, also called an cursor, for reading the
		 * example XML document.
		 */
		final FileInputStream theFileIS = new FileInputStream(KOMPIS_NOERR_XML_FILE_NAME);
		final XMLStreamReader theXMLCursor = theInputFactory.createXMLStreamReader(theFileIS);
		/* Create an stream writer in order to write to a file. */
		final FileWriter theOutputFileWriter = new FileWriter(XML_CURSOR_OUTPUT_FILE);
		final XMLStreamWriter theXMLWriter = theOutputFactory.createXMLStreamWriter(theOutputFileWriter);
		/*
		 * We will not receive a START_DOCUMENT event, so we have to put the
		 * code that initializes the output file here.
		 */
		theXMLWriter.writeStartDocument("UTF-8", "1.0");
		while (theXMLCursor.hasNext()) {
			final int theEventCode = theXMLCursor.next();
			switch (theEventCode) {
			case XMLStreamConstants.CHARACTERS: {
				System.out.println("*** Characters");
				/* Change all character data to lowercase only. */
				final String theCharacters = theXMLCursor.getText().trim();
				if (theCharacters.length() > 0) {
					theXMLWriter.writeCharacters(theCharacters.toLowerCase());
				}
				break;
			}
			case XMLStreamConstants.COMMENT: {
				System.out.println("*** Comment");
				/* Change all comments to uppercase only. */
				final String theComment = theXMLCursor.getText().toUpperCase();
				theXMLWriter.writeComment(theComment);
				break;
			}
			case XMLStreamConstants.END_DOCUMENT:
				System.out.println("*** End document");
				theXMLWriter.writeEndDocument();
				theXMLWriter.flush();
				theXMLWriter.close();
				break;
			case XMLStreamConstants.END_ELEMENT:
				System.out.println("*** End element");
				theXMLWriter.writeEndElement();
				break;
			case XMLStreamConstants.NAMESPACE:
				System.err.println("--- A namespace event was ignored");
				break;
			case XMLStreamConstants.START_DOCUMENT:
				System.out.println("--- Start document");
				break;
			case XMLStreamConstants.START_ELEMENT:
				System.out.println("*** Start element");
				/*
				 * If the name originally is qualified, then we want to output a
				 * qualified name, otherwise output a local name only.
				 */
				final QName theElementQName = theXMLCursor.getName();
				final String theNameSpace = theElementQName.getNamespaceURI();
				if (theNameSpace.length() > 0) {
					theXMLWriter.writeStartElement(theElementQName.getPrefix(),
							theElementQName.getLocalPart(), theNameSpace);
				} else {
					theXMLWriter.writeStartElement(theElementQName.getLocalPart());
				}
				/* List all the attributes, if any. */
				final int theAttributeCount = theXMLCursor.getAttributeCount();
				for (int i = 0; i < theAttributeCount; i++) {
					final QName theAttributeQName = theXMLCursor.getAttributeName(i);
					final String theAttributeValue = theXMLCursor.getAttributeValue(i);
					/*
					 * If the attribute has a namespace specified, then write
					 * the fully qualified name of the attribute, otherwise just
					 * write the local name.
					 */
					final String theAttributeNameSpace = theAttributeQName.getNamespaceURI();
					if (theAttributeNameSpace.length() > 0) {
						theXMLWriter.writeAttribute(theAttributeQName.getPrefix(), theAttributeNameSpace,
								theAttributeQName.getLocalPart(), theAttributeValue);
					} else {
						theXMLWriter.writeAttribute(theAttributeQName.getLocalPart(), theAttributeValue);
					}
				}
				break;
			default:
				System.err.println("Unrecognized event: " + theEventCode);
			}
		}
	}
}